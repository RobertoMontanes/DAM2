export interface ListadoGasolinerasResponse {
    Fecha: String,
    ListaEESSPrecio: any[],
    Nota: String,
    ResultadoConsulta: String
}

export class Gasolinera {
    id!: string;
    rotulo!: string;
    direccion!: string;
    localidad!: string;
    municipio!: string;
    provincia!: string;
    cp!: string;
    horario!: string;
    coordenadas!: {
        latitud: number;
        longitud: number;
    };
    precios!: {
        gasoleoA?: number;
        gasoleoPremium?: number;
        gasolina95E5?: number;
        gasolina98E5?: number;
    };

    constructor() {
        this.coordenadas = {
            latitud: 0,
            longitud: 0
        };
        this.precios = {};
    }
}


