CREATE TABLE TALLER_SITUACION(
   ID_TALLER_SITUACION NUMERIC(2,0) NOT NULL PRIMARY KEY,
   NOMBRE VARCHAR2(10) NOT NULL,
   ESTADO char(1) DEFAULT '1'
);

CREATE TABLE TALLER (
   ID_TALLER NUMERIC(10,0) NOT NULL PRIMARY KEY,
   NOMBRE varchar2(120) NOT NULL,
   DESCRIPCION varchar2(4000) NOT NULL,
   ID_INSTRUCTOR NUMERIC(2,0) NOT NULL,
   ID_TALLER_SITUACION NUMERIC(2,0) NOT NULL REFERENCES TALLER_SITUACION (ID_TALLER_SITUACION),
   FECHA_PROGRAMADA DATE  NULL,
   FECHA_REGISTRO DATE NULL,
   HORA_INICIO varchar2(10)  NULL,
   HORA_TERMINO varchar2(10)  NULL,
   DURACION NUMERIC(2,0)  NULL,
   ESTADO char(1) DEFAULT '1'
);
