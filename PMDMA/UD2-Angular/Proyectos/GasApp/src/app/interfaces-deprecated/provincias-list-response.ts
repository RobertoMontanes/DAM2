export interface Provincia {
    IDPovincia: string;
    IDCCAA: string;
    Provincia: string;
    CCAA: string;
}

export interface ProvinciaSorted {
    IDCCAA: string,
    ComunidadAutonoma: String,
    Provincias: Provincia[]
}

export interface ComunidadAutonoma {
    IDCCAA: string,
    ComunidadAutonoma: String
}

export type ProvinciasListResponse = Provincia[];