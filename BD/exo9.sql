http://orainfo.iutmontp.univ-montp2.fr:5560/isqlplus/login.uix

DROP TABLE Travailler CASCADE CONSTRAINTS;
DROP TABLE EtreAffecte CASCADE CONSTRAINTS;
DROP TABLE Projets CASCADE CONSTRAINTS;
DROP TABLE Equipes CASCADE CONSTRAINTS;
DROP TABLE Salaries CASCADE CONSTRAINTS;

/* CREATION DES TABLES */

CREATE TABLE Salaries
(codeSalarie VARCHAR(5), nomSalarie VARCHAR(25), prenomSalarie VARCHAR(25), nbTotalJourneesTravail NUMBER,
CONSTRAINT pk_Salaries PRIMARY KEY (codeSalarie));

CREATE TABLE Equipes
(codeEquipe VARCHAR(5), nomEquipe VARCHAR(25), codeSalarieChef VARCHAR(5),
CONSTRAINT pk_Equipes PRIMARY KEY (codeEquipe),
CONSTRAINT fk_Equipes_codeSalarieChef FOREIGN KEY (codeSalarieChef) REFERENCES Salaries(codeSalarie));

CREATE TABLE Projets
(codeProjet VARCHAR(5), nomProjet VARCHAR(25), villeProjet VARCHAR(25), codeEquipe VARCHAR(25),
CONSTRAINT nn_Projets CHECK (codeEquipe IS NOT NULL),
CONSTRAINT pk_Projets PRIMARY KEY (codeProjet),
CONSTRAINT fk_Projets_codeEquipe FOREIGN KEY (codeEquipe) REFERENCES Equipes(codeEquipe));

CREATE TABLE EtreAffecte
(codeSalarie VARCHAR(5), codeEquipe VARCHAR(5),
CONSTRAINT pk_EtreAffecte PRIMARY KEY (codeSalarie, codeEquipe),
CONSTRAINT fk_EtreAffecte_codeSalarie FOREIGN KEY (codeSalarie) REFERENCES Salaries(codeSalarie),
CONSTRAINT fk_EtreAffecte_codeEquipe FOREIGN KEY (codeEquipe) REFERENCES Equipes(codeEquipe));

CREATE TABLE Travailler
(codeSalarie VARCHAR(5), dateTravail DATE, codeProjet VARCHAR(5),
CONSTRAINT pk_Travailler PRIMARY KEY (codeSalarie, dateTravail),
CONSTRAINT fk_Travailler_codeSalarie FOREIGN KEY (codeSalarie) REFERENCES Salaries(codeSalarie),
CONSTRAINT fk_Travailler_codeProjet FOREIGN KEY (codeProjet) REFERENCES Projets(codePRojet));

/* INSERTION DE DONNEES */ 

INSERT INTO Salaries (codeSalarie, nomSalarie,prenomSalarie, nbTotalJourneesTravail) (SELECT * FROM Palleja.UNI_Salaries);
INSERT INTO Equipes (codeEquipe, nomEquipe, codeSalarieChef) (SELECT * FROM Palleja.UNI_Equipes);
INSERT INTO PROJETS (codeProjet, nomProjet, villeProjet, codeEquipe) (SELECT * FROM Palleja.UNI_Projets);
INSERT INTO EtreAffecte (codeSalarie, codeEquipe) (SELECT * FROM Palleja.UNI_EtreAffecte);
INSERT INTO Travailler (codeSalarie, dateTravail, codeProjet) (SELECT * FROM Palleja.UNI_Travailler);
COMMIT;


/* code */


Create or replace procedure AjouterJourneeTravail(p_codeSalarie Travailler.codeSalarie%TYPE, 
p_codeProjet Travailler.codeProjet%TYPE, p_dateTravail Travailler.dateTravail%TYPE) IS 
v_nbtemps NUMBER;
BEGIN
SELECT nbTotalJourneesTravail into v_nbtemps
from Salaries s 
where s.codeSalarie = p_codeSalarie;
INSERT INTO Travailler(codeSalarie, codeProjet, dateTravail) Values (p_codeSalarie, p_codeProjet, p_dateTravail);
v_nbtemps := v_nbtemps+1;
update Salaries set nbTotalJourneesTravail = v_nbtemps where codeSalarie=p_codeSalarie;
END;
/
show ERRORS

CALL AjouterJourneeTravail('S2','P3','10/01/2014');
SELECT nbTotalJourneesTravail
from Salaries 
where codeSalaire = 'S2';

/*     */
CREATE OR REPLACE PROCEDURE AffecterSalarieEquipe(p_codeSalarie EtreAffecte.codeSalarie%TYPE, p_codeEquipe EtreAffecte.codeEquipe%TYPE) IS
v_nbEquipe NUMBER;
BEGIN 
Select count(*) into v_nbEquipe
From EtreAffecte 
where codeSalarie=p_codeSalarie;
IF v_nbEquipe<=3 THEN
INSERT INTO EtreAffecte(codeSalarie,codeEquipe) VALUES (p_codeSalarie,p_codeEquipe);
ELSE
RAISE_APPLICATION_ERROR(-20001, 'Le salarié est déjà affecté à au moins 3 équipes');
END IF;
END; 
/
show ERRORS

CALL AffecterSalarieEquipe('S1','E3');

SELECT *
From EtreAffecte
WHERE codeSalarie = 'S1'
AND codeEquipe='E3';

CALL AffecterSalarieEquipe('S8','E1');

SELECT *
From EtreAffecte
WHERE codeSalarie = '81'
AND codeEquipe='E1';

/*      */
ALTER TABLE Equipes
ADD CONSTRAINT fk_Equipes_ChefAffecte FOREIGN KEY (codeEquipe,codeSalarieChef) REFERENCES EtreAffecte(codeEquipe,codeSalarie);

/*	*/
CREATE OR REPLACE PROCEDURE AjouterJourneeTravail(p_codeSalarie Travailler.codeSalarie%type, 
	p_codeProjet Travailler.codeProjet%type, p_dateTravail Travailler.dateTravail%type) IS
v_nb NUMBER;
BEGIN
Select Count(*) INTO v_nb
FROM EtreAffecte ea 
JOIN Projets p on ea.codeEquipe=p.codeEquipe
WHERE codeSalarie = p_codeSalarie AND codeProjet=p_codeProjet;
IF v_nb=0 THEN
RAISE_APPLICATION_ERROR(-20003, 'un salarié ne peut pas travailler sur un projet qui est réalisé par une équipe dans laquelle il n''est pas affecté');
ELSE
INSERT INTO Travailler (codeSalarie,codeProjet,dateTravail) VALUES (p_codeSalarie,p_codeProjet,p_dateTravail);
UPDATE Salaries
SET nbTotalJourneesTravail = nbTotalJourneesTravail+1
WHERE codeSalarie = p_codeSalarie;
END IF;
END;
/
show ERRORS

/*	*/
CREATE OR REPLACE TRIGGER tr_JourneesTravail 
AFTER INSERT OR UPDATE OR DELETE ON Travailler
FOR EACH ROW
BEGIN 
IF(DELETING OR UPDATING) THEN
UPDATE Salaries
SET nbTotalJourneesTravail=nbTotalJourneesTravail-1
where codeSalarie=:OLD.codeSalarie;
END IF;

IF(INSERTING OR UPDATING) THEN
UPDATE Salaries
SET nbTotalJourneesTravail=nbTotalJourneesTravail+1
where codeSalarie=:NEW.codeSalarie;
END IF;
end;

INSERT INTO Travailler VALUES('S1','10/01/2014','P1');
SELECT nbTotalJourneesTravail
FROM Salaries
WHERE CodeSalarie ='S1';

/*	*/

CREATE OR REPLACE TRIGGER tr_SalarieAffecte
BEFORE INSERT ON EtreAffecte
FOR EACH ROW
DECLARE v_nb NUMBER;
BEGIN
SELECT Count(codeEquipe) INTO v_nb
FROM EtreAffecte
WHERE codeSalarie=:NEW.codeSalarie;
IF v_nb>=3 THEN
RAISE_APPLICATION_ERROR(-20001, 'Le salarié est déjà affecté à au moins 3 équipes');
END IF;
END;

INSERT INTO EtreAffecte VAlues('S2','E4');
Select*
From EtreAffecte
WHERE codeSalarie = 'S2'
AND codeEquipe ='E4';

INSERT INTO EtreAffecte VAlues('S7','E4');
Select*
From EtreAffecte
WHERE codeSalarie = 'S7'
AND codeEquipe ='E4';

/* */
CREATE OR REPLACE VIEW Affectations(codeSalarie,nomSalarie,prenomSalarie,codeEquipe,nomEquipe)
AS Select s.codeSalarie,s.nomSalarie,s.prenomSalarie,e.codeEquipe,e.nomEquipe
FROM Salaries s
JOIN EtreAffecte ea on s.codeSalarie=ea.codeSalarie
JOIN Equipes e on ea.codeEquipe=e.codeEquipe 