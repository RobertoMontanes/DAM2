import { Component } from '@angular/core';

type Task = {
  id: number;
  title: string;
  done: boolean;
};

@Component({
  selector: 'app-task-list',
  imports: [],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css',
})
export class TaskList {
  modificarEstado(id: number) {
    this.tasks.forEach(elemento => {
      if (elemento.id == id) {
          elemento.done = !elemento.done
          return
      }
    })
  }
  tasks: Task[] = [
    {id: 1, title: 'Hacer la compra', done: false },
    {id: 2, title: 'Estudiar Angular', done: true },
    {id: 3, title: 'Pasear al perro', done: false },
  ];
}
