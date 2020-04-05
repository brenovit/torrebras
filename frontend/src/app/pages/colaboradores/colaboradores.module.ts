import { ThemeModule } from "./../../@theme/theme.module";
import {
  NbButtonModule,
  NbCardModule,
  NbTreeGridModule,
  NbIconModule,
  NbInputModule
} from "@nebular/theme";
import {
  ColaboradoresListComponent,
  FsIconComponent
} from "./colaboradores-list/colaboradores-list.component";
import { NgModule } from "@angular/core";
import { ColaboradoresComponent } from "./colaboradores.component";

@NgModule({
  imports: [
    NbButtonModule,
    NbCardModule,
    NbTreeGridModule,
    NbIconModule,
    NbInputModule,
    ThemeModule
  ],
  declarations: [
    ColaboradoresComponent,
    ColaboradoresListComponent,
    FsIconComponent
  ]
})
export class ColaboradoresModule {}
