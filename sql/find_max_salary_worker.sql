SELECT NAME, SALARY FROM WORKER
                    WHERE SALARY = (SELECT max(SALARY) FROM WORKER);