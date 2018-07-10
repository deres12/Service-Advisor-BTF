export interface JobService {
    id: number,
    descrizione: string
  }
  
  export interface Job {
    id: number,
    nome: string,
    icon: string,
    servizi: JobService[]
  }
