import { Component, OnInit } from "@angular/core";

class ColaboradorCurso {
  constructor(
    public nome: string,
    public funcao: string,
    public matricula: string,
    public aso: string,
    public ssma: string,
    public birgada: string,
    public rolante: string,
    public nr35: string,
    public nr10: string,
    public pta: string,
    public empilhadeira: string,
    public nr20: string
  ) {}
}

@Component({
  selector: "app-tables",
  templateUrl: "./tables.component.html",
  styleUrls: ["./tables.component.scss"],
})
export class TablesComponent implements OnInit {
  dados: ColaboradorCurso[] = new Array();

  constructor() {}

  ngOnInit() {
    this.loadDados();
  }

  loadDados() {
    this.dados.push(
      new ColaboradorCurso(
        "João",
        "Tecnico",
        "4654",
        "14/05/2020",
        "14/05/2020",
        "14/05/2020",
        "--",
        "--",
        "14/05/2020",
        "14/05/2020",
        "14/05/2020",
        "--"
      )
    );
    this.dados.push(
      new ColaboradorCurso(
        "Marcos",
        "Soldador",
        "0987",
        "14/05/2020",
        "--",
        "14/05/2020",
        "14/05/2020",
        "--",
        "14/05/2020",
        "14/05/2020",
        "14/05/2020",
        "14/05/2020"
      )
    );
    this.dados.push(
      new ColaboradorCurso(
        "Paulo",
        "Segurança",
        "6098",
        "--",
        "--",
        "14/05/2020",
        "14/05/2020",
        "--",
        "14/05/2020",
        "14/05/2020",
        "--",
        "14/05/2020"
      )
    );
  }
}
