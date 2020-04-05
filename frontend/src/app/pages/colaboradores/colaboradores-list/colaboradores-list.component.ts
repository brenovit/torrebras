import { Component, Input } from "@angular/core";
import {
  NbSortDirection,
  NbSortRequest,
  NbTreeGridDataSource,
  NbTreeGridDataSourceBuilder
} from "@nebular/theme";
interface TreeNode<T> {
  data: T;
  children?: TreeNode<T>[];
  expanded?: boolean;
}

interface FSEntry {
  nome: string;
  funcao_descricao: string;
  matricula?: string;
  validade?: string;
  cursos?: number;
}

@Component({
  selector: "ngx-colaboradores-list",
  templateUrl: "./colaboradores-list.component.html",
  styleUrls: ["./colaboradores-list.component.scss"]
})
export class ColaboradoresListComponent {
  customColumn = "nome";
  defaultColumns = ["matricula", "funcao_descricao", "validade", "cursos"];
  allColumns = [this.customColumn, ...this.defaultColumns];

  dataSource: NbTreeGridDataSource<FSEntry>;

  sortColumn: string;
  sortDirection: NbSortDirection = NbSortDirection.NONE;

  constructor(private dataSourceBuilder: NbTreeGridDataSourceBuilder<FSEntry>) {
    this.dataSource = this.dataSourceBuilder.create(this.data);
  }

  updateSort(sortRequest: NbSortRequest): void {
    this.sortColumn = sortRequest.column;
    this.sortDirection = sortRequest.direction;
  }

  getSortDirection(column: string): NbSortDirection {
    if (this.sortColumn === column) {
      return this.sortDirection;
    }
    return NbSortDirection.NONE;
  }

  private data: TreeNode<FSEntry>[] = [
    {
      data: {
        nome: "Marcos",
        funcao_descricao: "Tecnico Segurança",
        matricula: "0045",
        cursos: 2
      },
      children: [
        {
          data: {
            nome: "NR 35",
            funcao_descricao: "Altura",
            validade: "10/04/2020"
          }
        },
        {
          data: {
            nome: "NR 23",
            funcao_descricao: "Brigada",
            validade: "10/05/2020"
          }
        }
      ]
    },
    {
      data: {
        nome: "João",
        funcao_descricao: "Soldador",
        matricula: "0496",
        cursos: 3
      },
      children: [
        {
          data: {
            nome: "NR 35",
            funcao_descricao: "Altura",
            validade: "10/04/2020"
          }
        },
        {
          data: {
            nome: "NR 23",
            funcao_descricao: "Brigada",
            validade: "10/05/2020"
          }
        },
        {
          data: {
            nome: "NR 11/12",
            funcao_descricao: "PTA",
            validade: "01/04/2020"
          }
        }
      ]
    }
  ];

  getShowOn(index: number) {
    const minWithForMultipleColumns = 400;
    const nextColumnStep = 100;
    return minWithForMultipleColumns + nextColumnStep * index;
  }
}
@Component({
  selector: "ngx-fs-icon",
  template: `
    <nb-tree-grid-row-toggle
      [expanded]="expanded"
      *ngIf="isColaborador(); else curso"
    >
    </nb-tree-grid-row-toggle>
    <ng-template #curso>
      <nb-icon icon="book-outline"></nb-icon>
    </ng-template>
  `
})
export class FsIconComponent {
  @Input() matricula: string;
  @Input() expanded: boolean;

  isColaborador(): boolean {
    return this.matricula != null;
  }
}
