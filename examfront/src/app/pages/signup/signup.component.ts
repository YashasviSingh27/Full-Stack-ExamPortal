import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit{
  constructor(private userService: UserService, private snack:MatSnackBar){}
  public user={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:'',
  };
  ngOnInit(): void{}
  formSubmit(){
    console.log(this.user);
    if(this.user.username =='' || this.user.username == null){
      this.snack.open("User Name is Required",'ok',{duration:3000});
      return;
    }

//     add user
    this.userService.addUser(this.user).subscribe(
      (data:any)=>{
//         For Success
        console.log(data);
        Swal.fire('Signup Successfully !','Your User Id is: '+data.id,'success');
      },
      (error)=>{
//      For Error
        console.log(error);
        this.snack.open("Something went Wrong !!",'ok',{duration:3000});
      }
    );
  }
}
