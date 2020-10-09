export class Pelicula{
  constructor(
    public id: number,
    public nombre: string,
    public genero: string,
    public director?: string
  ){}
}
