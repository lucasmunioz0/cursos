export interface Usuario{
  id: number;
  codigo: string;
  permiso: string;
}

export interface IPost{
  id: number;
  userId: number;
  title: string;
  body: string;
}
