CREATE TABLE TipoPregunta(
	idTipoPregunta int NOT NULL UNIQUE AUTO_INCREMENT,
    nombre varchar(50),
    Primary Key (idTipoPregunta)
);

CREATE TABLE Empresa(
	idEmpresa int NOT NULL UNIQUE AUTO_INCREMENT,
    nombre varchar(50),
    Primary Key (idEmpresa)
);

CREATE TABLE Encuesta(
	idEncuesta int NOT NULL UNIQUE AUTO_INCREMENT,
    nombre varchar(50),
    descripcion varchar(250),
    fechaAlta datetime,
    fechaBaja datetime,
    idEmpresa int,
    Primary Key (idEncuesta),
    Foreign Key (idEmpresa) REFERENCES Empresa(idEmpresa)    
);

CREATE TABLE Pregunta(
	idPregunta int NOT NULL UNIQUE AUTO_INCREMENT,
    descripcion varchar(50),
    idTipoPregunta int NOT NULL,
    activo bit,
    idEncuesta int NOT NULL,
    fechaAlta datetime,
    fechaBaja datetime,
    Primary Key (idPregunta),
    Foreign Key (idTipoPregunta) REFERENCES TipoPregunta(idTipoPregunta),
    Foreign Key (idEncuesta) REFERENCES Encuesta(idEncuesta)
);

CREATE TABLE Opcion(
	idOpcion int NOT NULL UNIQUE AUTO_INCREMENT,
    descripcion varchar(50),
    activo bit,
    idPregunta int NOT NULL,
    fechaAlta datetime,
    fechaBaja datetime,
    Primary Key(idOpcion),
    Foreign Key (idPregunta) REFERENCES Pregunta(idPregunta)
);

CREATE TABLE EncuestaRespondida(
	idEncuestaRespondida int NOT NULL UNIQUE AUTO_INCREMENT,
    idEncuesta int NOT NULL,
    fechaCreacion datetime,
    Primary Key (idEncuestaRespondida),
    Foreign Key (idEncuesta) REFERENCES Encuesta(idEncuesta)
);

CREATE TABLE Respuesta(
	idRespuesta int NOT NULL UNIQUE AUTO_INCREMENT,
    idEncuestaRespondida int NOT NULL,
    idPregunta int NOT NULL,
    respuestaLibre varchar(250),
    Primary Key (idRespuesta),
    Foreign Key (idPregunta) REFERENCES Pregunta(idPregunta)
);

CREATE TABLE RespuestaOpcion(
	idRespuestaOpcion int NOT NULL UNIQUE AUTO_INCREMENT,
    idRespuesta int NOT NULL,
    idOpcion int NOT NULL,
    Primary Key (idRespuesta),
    Foreign Key (idOpcion) REFERENCES Opcion(idOpcion),
    Foreign Key (idRespuesta) REFERENCES Respuesta(idRespuesta)
);

CREATE TABLE Establecimiento(
	idEstablecimiento int NOT NULL UNIQUE AUTO_INCREMENT,
    fechaAlta datetime,
    fechaBaja datetime,
    nombre varchar(50),
    direccion varchar(50),
    activo bit,
    idEmpresa int NOT NULL,
    Primary Key (idEstablecimiento),
    Foreign Key (idEmpresa) REFERENCES Empresa(idEmpresa)    
);

CREATE TABLE FichaMedica(
	idFichaMedica int NOT NULL UNIQUE AUTO_INCREMENT,
    idEncuestaRespondida int NOT NULL,
    idProfesional int NOT NULL,
    idEstablecimiento int NOT NULL,
	idMascota int NOT NULL,
    fechaCreacion timestamp,
    Primary Key (idFichaMedica),
    Foreign Key (idEncuestaRespondida) REFERENCES EncuestaRespondida(idEncuestaRespondida),
    Foreign Key (idProfesional) REFERENCES Profesional(idProfesional),
    Foreign Key (idEstablecimiento) REFERENCES Establecimiento(idEstablecimiento),
    Foreign Key (idMascota) REFERENCES Mascota(idMascota)
);

CREATE TABLE Mascota(
	idMascota int NOT NULL UNIQUE AUTO_INCREMENT,
    nombre varchar(50),
    idCliente int NOT NULL,
    Primary Key (idMascota),
    Foreign Key (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE Turno(
	idTurno int NOT NULL UNIQUE AUTO_INCREMENT,
    idProfesional int,
    idEstablecimiento int,
    activo bit,
    cantHoras int,
    Primary Key (idTurno),
    Foreign Key (idProfesional) REFERENCES Profesional(idProfesional),
    Foreign Key (idEstablecimiento) REFERENCES Establecimiento(idEstablecimiento)
);

CREATE TABLE Profesional(
	idProfesional int NOT NULL UNIQUE AUTO_INCREMENT,
    matricula int,
    nombre varchar(50),
    apellido varchar(50),
    activo bit,
    Primary Key (idProfesional)
);

CREATE TABLE Cliente(
	idCliente int NOT NULL UNIQUE AUTO_INCREMENT,
    nombre varchar(50),
    apellido varchar(50),
    dni int,
    idEmpresa int,
    Primary Key (idCliente),
    Foreign Key (idEmpresa) REFERENCES Empresa(idEmpresa)
);