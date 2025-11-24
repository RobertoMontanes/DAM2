export interface PeopleListResponse {
    page: number;
    results: Person[];
    total_pages: number;
    total_results: number;
}

export interface Person {
    adult: boolean;
    gender: number;
    id: number;
    known_for_department: string;
    name: string;
    original_name: string;
    popularity: number;
    profile_path: string;
    known_for: (Movie | TVShow)[];
}

export interface Movie {
    adult: boolean;
    backdrop_path: string | null;
    id: number;
    title: string;
    original_language: string;
    original_title: string;
    overview: string;
    poster_path: string;
    media_type: "movie";
    genre_ids: number[];
    popularity: number;
    release_date: string;
    video: boolean;
    vote_average: number;
    vote_count: number;
}

export interface TVShow {
    adult: boolean;
    backdrop_path: string | null;
    id: number;
    name: string;
    original_name: string;
    overview: string;
    poster_path: string;
    media_type: "tv";
    original_language: string;
    genre_ids: number[];
    popularity: number;
    first_air_date: string;
    vote_average: number;
    vote_count: number;
    origin_country: string[];
}