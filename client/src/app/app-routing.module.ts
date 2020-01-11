import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainPageComponent } from './components/main-page/main-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ProductComponent } from './components/shared/product/product.component';

const routes: Routes = [
  {path: 'main', component: MainPageComponent},
  {path: '', component: LoginPageComponent},
  {path: 'product', component: ProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
