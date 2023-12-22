import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 public employees:Employee[]=[];
 public editEmployee:Employee | null=null;

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

 public onAddEmployee(addForm: NgForm):void{
  document.getElementById('add-employee-form')?.click();
  this.employeeServices.addEmployee(addForm.value).subscribe(
    (response:Employee)=>{
      console.log(response);
      this.getEmployees();
      addForm.reset();
    },
    (error:HttpErrorResponse)=>{
      alert(error.message);
    }
  )
 }
 public onUpdateEmployee(employee:Employee):void{
  this.employeeServices.updateEmployee(employee).subscribe(
    (response:Employee)=>{
      console.log(response);
      this.getEmployees();
    },
    (error:HttpErrorResponse)=>{
      alert(error.message);
    }
  )
 }
 public onDeleteEmployee(employeeId:number){
  this.employeeServices.deleteEmployee(employeeId).subscribe(
    (response:void)=>{
      console.log(response);
      this.getEmployees();
    },
    (error:HttpErrorResponse)=>{
      alert(error.message);
    }
  )
 }
 public onOpenModal(employee: Employee |null, mode:string){
  const button=document.createElement('button');
  const container=document.getElementById('main-container');
  button.type='button';
  button.style.display='none';
  button.setAttribute('data-toggle', 'modal');
  if(mode==='add'){
    button.setAttribute('data-target', '#addEmployeeModal')
  }
  if(mode==='edit'){
    this.editEmployee=employee;
    button.setAttribute('data-target', '#updateEmployeeModal')
  }
  if(mode==='delete'){
    button.setAttribute('data-target', '#deleteEmployeeModal')
  }
  container?.appendChild(button);
  button.click();
 }
}


