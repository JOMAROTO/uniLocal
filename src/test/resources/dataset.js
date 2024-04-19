db = connect('mongodb://root:example@localhost:27017/uniLocal_PA?authSource=admin');
db.clientes.insertMany([
    {
        _id: 'Cliente1',
        nickname: 'juanito',
        ciudadResidencia: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'juan@email.com',
        password: 'mipassword',
        nombre: 'Juan',
        estadoRegistro: 'ACTIVO',
        listaNegociosFavoritos: ['Negocio5'],
        listaPublicacionesFavoritas: ['Publicacion5'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente2',
        nickname: 'Pepito',
        ciudadResidencia: 'Pereira',
        fotoPerfil: 'mi foto',
        email: 'Pepe@email.com',
        password: 'mipassword',
        nombre: 'Pepe',
        estadoRegistro: 'INACTIVO',
        listaNegociosFavoritos: ['Negocio4'],
        listaPublicacionesFavoritas: ['Publicacion4'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente3',
        nickname: 'Carlitos',
        ciudadResidencia: 'Bogotá',
        fotoPerfil: 'mi foto',
        email: 'carlos@email.com',
        password: 'mipassword',
        nombre: 'Carlos',
        estadoRegistro: 'ACTIVO',
        listaNegociosFavoritos: ['Negocio2'],
        listaPublicacionesFavoritas: ['Publicacion3'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente4',
        nickname: 'Luisito',
        ciudadResidencia: 'Medellin',
        fotoPerfil: 'mi foto',
        email: 'luis@email.com',
        password: 'mipassword',
        nombre: 'Luis',
        estadoRegistro: 'INACTIVO',
        listaNegociosFavoritos: ['Negocio2'],
        listaPublicacionesFavoritas: ['Publicacion2'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente5',
        nickname: 'Julanita',
        ciudadResidencia: 'Cartagena',
        fotoPerfil: 'mi foto',
        email: 'julana@email.com',
        password: 'mipassword',
        nombre: 'Julana',
        estadoRegistro: 'ACTIVO',
        listaNegociosFavoritos: ['Negocio1'],
        listaPublicacionesFavoritas: ['Publicacion1'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    }
]);

db.negocios.insertMany([
    {
        _id: 'Negocio1',
        codigoCliente: 'Cliente1',
        nombre: 'Cafeteria la esperanza',
        descripcion: 'Cafeteria de Armenia con los mejores cafés',
        categoriaNegocio: 'CAFETERIA',
        estadoNegocio: 'APROBADO',
        ubicacion: {
            longitud: 4.12355,
            latitud: -75.12305
        },
        listaTelefonos: ['3101234567'],
        listaRutasImagenes: ['host.com/miimagen'],
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'

    },
    {
        _id: 'Negocio2',
        codigoCliente: 'Cliente2',
        nombre: 'Panzetti',
        descripcion: 'El mejor pan aliñado',
        categoriaNegocio: 'PANADERIA',
        estadoNegocio: 'RECHAZADO',
        ubicacion: {
            longitud: 1.12355,
            latitud: -55.12305
        },
        listaTelefonos: ['3101234567', '3209876543'],
        listaRutasImagenes: ['host.com/miimagen', 'host.com/miimagen2'],
        listaHorarios: [
            {
                diaSemana: 'MARTES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoRegistro: 'INACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio3',
        codigoCliente: 'Cliente3',
        nombre: 'Ferreteria la ilusión',
        descripcion: 'La mejor ferretería de Pereira',
        categoriaNegocio: 'FERRETERIA',
        estadoNegocio: 'PENDIENTE',
        ubicacion: {
            longitud: 7.12355,
            latitud: -10.12305
        },
        listaTelefonos: ['3111269342'],
        listaRutasImagenes: ['host.com/miimagen'],
        listaHorarios: [
            {
                diaSemana: 'MIERCOLES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoRegistro: 'INACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio4',
        codigoCliente: 'Cliente4',
        nombre: 'Tecnologic S.A.S',
        descripcion: 'El almacen donde encuentras todo de tecnologia',
        categoriaNegocio: 'TIENDA_TECNOLOGICA',
        estadoNegocio: 'APROBADO',
        ubicacion: {
            longitud: 7.12355,
            latitud: -90.12305
        },
        listaTelefonos: ['3101234567'],
        listaRutasImagenes: ['host.com/miimagen'],
        listaHorarios: [
            {
                diaSemana: 'JUEVES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio5',
        codigoCliente: 'Cliente5',
        nombre: 'Nike sucursal norte',
        descripcion: 'Sucursal nike norte',
        categoriaNegocio: 'TIENDA_DEPORTIVA',
        estadoNegocio: 'RECHAZADO',
        ubicacion: {
            longitud: 0.12355,
            latitud: -15.12305
        },
        listaTelefonos: ['3217512867'],
        listaRutasImagenes: ['host.com/miimagen'],
        listaHorarios: [
            {
                diaSemana: 'VIERNES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoRegistro: 'INACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    }
]);

db.calificaciones.insertMany([
    {
        _id: 'Calificacion1',
        codigoCliente: 'Cliente1',
        fecha: new Date(),
        mensaje: 'Muy buen local',
        codigoNegocio: 'Negocio3',
        valoracion: 5,
        respuesta: '',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion'
    },
    {
        _id: 'Calificacion2',
        codigoCliente: 'Cliente2',
        fecha: new Date(),
        mensaje: 'Muy buena cafeteria, sirven un café muy bueno',
        codigoNegocio: 'Negocio1',
        valoracion: 5,
        respuesta: '',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion'
    },
    {
        _id: 'Calificacion3',
        codigoCliente: 'Cliente3',
        fecha: new Date(),
        mensaje: 'Productos demasiado costosos!',
        codigoNegocio: 'Negocio4',
        valoracion: 2,
        respuesta: '',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion'
    },
    {
        _id: 'Calificacion4',
        codigoCliente: 'Cliente4',
        fecha: new Date(),
        mensaje: 'Sirven buen café, sin embargo, la comida no es tan buena',
        codigoNegocio: 'Negocio1',
        valoracion: 3,
        respuesta: '',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion'
    },
    {
        _id: 'Calificacion5',
        codigoCliente: 'Cliente5',
        fecha: new Date(),
        mensaje: 'Execelente, me ayudaron a armar mi primer computador',
        codigoNegocio: 'Negocio4',
        valoracion: 5,
        respuesta: '',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion'
    }
]);

db.eventos.insertMany([
    {
        _id: 'Evento1',
        codigoNegocio: 'Negocio1',
        nombre: 'Feria del pan',
        descripcion: 'Ven a probar todos los tipos de panes de otros paises!',
        tipoEvento: 'CULTURAL',
        diasDisponible: [
            {
                diaSemana: 'LUNES',
                horaApertura: '14:00',
                horaCierre: '18:30'
            }
        ],
        estadoEvento: 'EN_CURSO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento'
    },
    {
        _id: 'Evento2',
        codigoNegocio: 'Negocio1',
        nombre: 'El chocolatazo',
        descripcion: 'Ven a tomar chocolate y te prestamos un libro!',
        tipoEvento: 'SOCIAL',
        diasDisponible: [
            {
                diaSemana: 'MARTES',
                horaApertura: '16:00',
                horaCierre: '20:30'
            }
        ],
        estadoEvento: 'EN_CURSO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento'
    },
    {
        _id: 'Evento3',
        codigoNegocio: 'Negocio4',
        nombre: 'Descuentos en procesadores intel',
        descripcion: 'Descuento en todo tipo de procesador intel!',
        tipoEvento: 'DESCUENTO',
        diasDisponible: [
            {
                diaSemana: 'JUEVES',
                horaApertura: '9:30',
                horaCierre: '21:00'
            }
        ],
        estadoEvento: 'EN_CURSO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento'
    },
    {
        _id: 'Evento4',
        codigoNegocio: 'Negocio4',
        nombre: 'Obsequio en compras! Armado de computador',
        descripcion: 'Te armamos el computador si compras con nosotros',
        tipoEvento: 'DESCUENTO',
        diasDisponible: [
            {
                diaSemana: 'JUEVES',
                horaApertura: '14:00',
                horaCierre: '18:30'
            }
        ],
        estadoEvento: 'FINALIZADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento'
    },
    {
        _id: 'Evento5',
        codigoNegocio: 'Negocio4',
        nombre: 'Taller de armado de reparación',
        descripcion: 'Te enseñamos a reparar un computador y como identificar las causas mas comunes!',
        tipoEvento: 'SOCIAL',
        diasDisponible: [
            {
                diaSemana: 'JUEVES',
                horaApertura: '15:00',
                horaCierre: '16:30'
            }
        ],
        estadoEvento: 'EN_CURSO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento'
    }
]);

db.moderadores.insertMany([
    {
        _id: 'Moderador1',
        nombre: 'Juan Aguilar',
        fotoPerfil: 'mifotodeperfil',
        password: 'password',
        email: 'JuanAg@unilocal.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador2',
        nombre: 'Ernesto Martinez',
        fotoPerfil: 'mifotodeperfil',
        password: 'ernesto321953',
        email: 'ernestomar@unilocal.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador3',
        nombre: 'Alba Herrera',
        fotoPerfil: 'mifotodeperfil',
        password: 'herrera123alba',
        email: 'albaher@unilocal.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador4',
        nombre: 'Manuel Cardona',
        fotoPerfil: 'mifotodeperfil',
        password: 'password',
        email: 'manuelcar@unilocal.com',
        estadoRegistro: 'INACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador5',
        nombre: 'Laura Cardona',
        fotoPerfil: 'mifotodeperfil',
        password: 'laucar9',
        email: 'lauracar@unilocal.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    }
]);

db.revisiones.insertMany([
    {
        _id: 'Revision1',
        fecha: new Date(),
        codigoModerador: 'Moderador1',
        codigoNegocio: 'Negocio1',
        descripcion: 'Todo cumple con los requisitos y normas de la pagina',
        EstadoNegocio: 'APROBADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision2',
        fecha: new Date(),
        codigoModerador: 'Moderador1',
        codigoNegocio: 'Negocio2',
        descripcion: 'No se cumplen con las normas de la pagina, por favor, revisar lo suministrado',
        EstadoNegocio: 'RECHAZADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision3',
        fecha: new Date(),
        codigoModerador: 'Moderador2',
        codigoNegocio: 'Negocio3',
        descripcion: 'Falta adjuntar los horarios',
        EstadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision4',
        fecha: new Date(),
        codigoModerador: 'Moderador3',
        codigoNegocio: 'Negocio4',
        descripcion: 'Todo cumple con los requisitos y normas de la pagina',
        EstadoNegocio: 'APROBADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'

    },
    {
        _id: 'Revision5',
        fecha: new Date(),
        codigoModerador: 'Moderador5',
        codigoNegocio: 'Negocio5',
        descripcion: 'No se cumplen con las normas de la pagina, por favor, revisar lo suministrado',
        EstadoNegocio: 'RECHAZADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'

    }
]);

db.publicaciones.insertMany([
    {
        _id: 'Publicacion1',
        codigoCliente: 'Cliente1',
        descripcion: 'El mejor sitio para tomar un café',
        rutaImagen: 'rutaimagen',
        fechaPublicacion: new Date(),
        estadoRegistro: 'ACTIVO',
        listaMeGustas: ['Cliente3'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion2',
        codigoCliente: 'Cliente1',
        descripcion: 'Mi primer compra! Computador gamer!',
        rutaImagen: 'rutaimagen',
        fechaPublicacion: new Date(),
        estadoRegistro: 'ACTIVO',
        listaMeGustas: ['Cliente3', 'Cliente5'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion3',
        codigoCliente: 'Cliente3',
        descripcion: 'Me encanta la comida de aquí!',
        rutaImagen: 'rutaimagen',
        fechaPublicacion: new Date(),
        estadoRegistro: 'ACTIVO',
        listaMeGustas: ['Cliente1', 'Cliente5'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion4',
        codigoCliente: 'Cliente5',
        descripcion: 'Me gusta el café pero me gusta mas el té',
        rutaImagen: 'rutaimagen',
        fechaPublicacion: new Date(),
        estadoRegistro: 'INACTIVO',
        listaMeGustas: ['Cliente1'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion5',
        codigoCliente: 'Cliente5',
        descripcion: 'No sé qué computador comprar',
        rutaImagen: 'rutaimagen',
        fechaPublicacion: new Date(),
        estadoRegistro: 'INACTIVO',
        listaMeGustas: ['Cliente3'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    }
]);

db.opiniones.insertMany([
    {
        _id: 'Opinion1',
        codigoCliente: 'Cliente3',
        codigoPublicacion: 'Publicacion1',
        fecha: new Date(),
        mensaje: 'Lo mejor es tomar café con pan!',
        listaMeGustas: ['Cliente3'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion2',
        codigoCliente: 'Cliente3',
        codigoPublicacion: 'Publicacion2',
        fecha: new Date(),
        mensaje: 'Felicidades!',
        listaMeGustas: ['Cliente1'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion3',
        codigoCliente: 'Cliente5',
        codigoPublicacion: 'Publicacion2',
        fecha: new Date(),
        mensaje: 'Allí dan los mejores precios!',
        listaMeGustas: ['Cliente3','Cliente2'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion4',
        codigoCliente: 'Cliente1',
        codigoPublicacion: 'Publicacion3',
        fecha: new Date(),
        mensaje: 'Sabe delicioso!',
        listaMeGustas: ['Cliente3','Cliente5'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion5',
        codigoCliente: 'Cliente5',
        codigoPublicacion: 'Publicacion3',
        fecha: new Date(),
        mensaje: 'Espero poder ir algun día',
        listaMeGustas: ['Cliente4'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    }
]);
