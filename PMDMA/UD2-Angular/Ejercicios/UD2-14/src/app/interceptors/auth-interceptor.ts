import { HttpInterceptorFn } from '@angular/common/http';


const API_TOKEN = 'eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MTBjZjY3ZDA3YTBhMDQ2YTMyNDgwZWI5MDk4YjI3YiIsIm5iZiI6MTc2MzM2NzQ4Mi4zMjQsInN1YiI6IjY5MWFkYTNhMDM5NGQ1YWQ0MjZkOTI1NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uD8kgDmUK2TeT41R5r50ZpqdOlutm3-q4G4nAXz2naQ';

export const authInterceptor: HttpInterceptorFn = (req, next) => {

  const authReq = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${API_TOKEN}`)
  });

  return next(authReq);
};
