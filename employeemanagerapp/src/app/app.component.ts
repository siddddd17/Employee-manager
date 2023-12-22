import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 public employees:Employee[]=[];

 constructor(private employeeServices:EmployeeService){}

 ngOnInit() {
   this.getEmployees();
 }
 public getEmployees():void{
  this.employeeServices.getEmployees().subscribe(
    (response:Employee[])=>{
      this.employees=response;
    },
    (error:HttpErrorResponse)=>{
        alert(error.message);
    }
  );
 }

 public onOpenModal(employee: Employee, mode:string){
  const button=document.createElement('button');
  const container=document.getElementById('main-container');
  button.type='button';
  button.style.display='none';
  button.setAttribute('data-toggle', 'modal');
  if(mode==='add'){
    button.setAttribute('data-target', '#addEmployeeModal')
  }
  if(mode==='edit'){
    button.setAttribute('data-target', '#updateEmployeeModal')
  }
  if(mode==='delete'){
    button.setAttribute('data-target', '#deleteEmployeeModal')
  }
  container?.appendChild(button);
  button.click();
 }
}


