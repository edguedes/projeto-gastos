export interface Spend {
  id: number;
  descricao: string;
  dataTransacao: string;
  valor: number;
  tags: boolean;
}

export interface CreateSpend {
  personId: number;
  descricao: string;
  valor: number;
  tags: boolean;
}
