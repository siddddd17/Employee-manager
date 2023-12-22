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
}
