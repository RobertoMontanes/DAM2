export interface AccountList {
    description: string;
    favorite_count: number;
    id: number;
    item_count: number;
    iso_639_1: string;
    list_type: string;
    name: string;
    poster_path: string | null;
}

export interface AccountListsResponse {
    page: number;
    results: AccountList[];
    total_pages: number;
    total_results: number;
}