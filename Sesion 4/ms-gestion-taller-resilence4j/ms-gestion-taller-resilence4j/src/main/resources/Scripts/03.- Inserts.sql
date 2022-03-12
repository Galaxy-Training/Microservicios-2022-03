
INSERT INTO TALLER_SITUACION(ID_TALLER_SITUACION,NOMBRE)
VALUES (SEQ_TALLER_SITUACION.NEXTVAL, 'PROGRAMADO');
INSERT INTO TALLER_SITUACION(ID_TALLER_SITUACION,NOMBRE)
VALUES (SEQ_TALLER_SITUACION.NEXTVAL, 'CERRADO');

commit;



INSERT INTO TALLER(ID_TALLER,NOMBRE,DESCRIPCION,ID_INSTRUCTOR,ID_TALLER_SITUACION,
FECHA_PROGRAMADA,FECHA_REGISTRO,HORA_INICIO,HORA_TERMINO,DURACION)
VALUES (SEQ_TALLER.NEXTVAL, 'JAVA 15','Mejoras y nuevas funcionalidades',1,1,
'17-11-2020',SYSDATE, '7:30pm','8:30pm',2);

INSERT INTO TALLER(ID_TALLER,NOMBRE,DESCRIPCION,ID_INSTRUCTOR,ID_TALLER_SITUACION,
FECHA_PROGRAMADA,FECHA_REGISTRO,HORA_INICIO,HORA_TERMINO,DURACION)
VALUES (SEQ_TALLER.NEXTVAL, 'Spring Boot 3.5','Plugins y nuevas funcionalidades',2,1,
'18-11-2020',SYSDATE, '7:30pm','8:30pm',2);

commit;

select * from TALLER;
