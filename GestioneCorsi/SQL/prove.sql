--OPERAZIONI_BASE CORSISTA
SELECT CORSISTA.COD_CORSISTA,CORSISTA.NOME_CORSISTA,CORSISTA.COGNOME_CORSITA,CORSISTA.PRECEDENTI_FORMATIVI 

FROM CORSISTA; -- PER INSERT E GET ALL

SELECT CORSISTA.*
FROM CORSISTA
WHERE COD_CORSISTA = ?

--END OPERAZIONE CORSISTA


--OPERAZIONI_BASE CORSO
SELECT CORSO.COD_CORSO,CORSO.NOME_CORSO,CORSO.DATA_INIZIO,CORSO.DATA_FINE,CORSO.COSTO_CORSO,CORSO.COMMENTI_CORSO,CORSO.AULA_CORSO,CORSO.COD_DOCENTE
FROM CORSO; --PER INSERT E GET ALL

SELECT CORSO.*
FROM CORSO
WHERE COD_CORSO = ? 

SELECT CORSO.*
FROM CORSO 
WHERE COD_DOCENTE = ?

DELETE FROM CORSO WHERE COD_CORSO = ? 
--END OPERAZIONE CORSO



--STATISTICHE
--1
SELECT COUNT(*)
FROM CORSISTA
--END 1
--2
SELECT COD_CORSO,COUNT(COD_CORSISTA) 
FROM CORSO_CORSITA
GROUP BY COD_CORSO
HAVING COUNT(COD_CORSISTA)  = 12
--END 2
--3 CONTROLLATA 
SELECT CORSO.*
FROM CORSO
WHERE DATA_INIZIO = (SELECT MAX(DATA_INIZIO)
                     FROM CORSO)
--END 3
--4

--END 4

--5 CONTROLLATA OK 
CREATE VIEW CORSO_COMMENTI AS 
SELECT DISTINCT COD_CORSO,regexp_substr(CORSO.commenti_corso, '[^;]+', 1, LEVEL) COMMENTI
FROM CORSO
CONNECT BY regexp_substr(CORSO.commenti_corso, '[^;]+', 1, LEVEL) IS NOT NULL;

CREATE VIEW CORSO_N_COMMENTI AS
SELECT COD_CORSO, COUNT(COMMENTI) AS NUMERO_COMMENTI
FROM CORSO_COMMENTI
GROUP BY COD_CORSO
;

SELECT SUM(NUMERO_COMMENTI)
FROM CORSO_N_COMMENTI

--END 5

--6
--UGUALE AL GET ALL
--END 

--7
CREATE VIEW DOCENTE_CV AS 
SELECT DISTINCT COD_DOCENTE,regexp_substr(DOCENTE.CV, '[^;]+', 1, LEVEL) MATERIE
FROM DOCENTE
CONNECT BY regexp_substr(DOCENTE.CV, '[^;]+', 1, LEVEL) IS NOT NULL;

SELECT COD_DOCENTE, COUNT(MATERIE) 
FROM DOCENTE_CV
GROUP BY COD_DOCENTE
HAVING COUNT(MATERIE) = (SELECT MAX(COUNT(MATERIE))
                        FROM DOCENTE_CV
                        GROUP BY COD_DOCENTE
                        
                        )
;
--END 7

--8
SELECT COD_CORSO,COUNT(COD_CORSISTA)
FROM CORSO_CORSISTA 
GROUP BY(COD_CORSO)
HAVING COUNT(COD_CORSISTA) = ( SELECT MIN(COUNT(COD_CORSISTA))
                               FROM CORSO_CORSISTA
                               GROUP BY COD_CORSO      
                            )
                            

--END 8
                     
---END STATISTICHE