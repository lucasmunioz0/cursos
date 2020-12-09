export class GeneradorWhatsApp {
  constructor() { }
  enviarRecordatorio(fecha: Date, cliente: string, mesa: string, comensales: number): string {
    return `
    Fecha: ${fecha}\n
    Cliente: ${cliente}\n
    Mesa: ${mesa}\n
    Comensales: ${comensales}
  `;
  }
}
