import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']   // ✅ CORRIGÉ
})
export class DashboardComponent {

  // ---------- VARIABLES ----------

  totalTasks: number = 0;
  completedTasks: number = 0;

  searchText: string = '';
  showSearch: boolean = false;

  showAddModal: boolean = false;
  newTaskTitle: string = '';
  newTaskPriority: string = 'medium';

  tasks = [
    { title: 'Finir le projet Angular', priority: 'high', completed: false },
    { title: 'Lire 10 pages', priority: 'medium', completed: true },
    { title: 'Faire du sport', priority: 'low', completed: false }
  ];

  // ---------- CONSTRUCTOR ----------

  constructor() {
    this.updateStats();
  }

  // ---------- METHODES ----------

  toggleSearch() {
    this.showSearch = !this.showSearch;
  }

  addTask() {
    if (!this.newTaskTitle.trim()) return;

    this.tasks.push({
      title: this.newTaskTitle,
      priority: this.newTaskPriority,
      completed: false
    });

    this.newTaskTitle = '';
    this.newTaskPriority = 'medium';
    this.showAddModal = false;

    this.updateStats();
  }

  toggleTask(task: any) {
    task.completed = !task.completed;
    this.updateStats();
  }

  deleteTask(index: number) {
    this.tasks.splice(index, 1);
    this.updateStats();
  }

  editTask(task: any) {
    const newTitle = prompt('Modifier la tâche :', task.title);
    if (newTitle !== null && newTitle.trim() !== '') {
      task.title = newTitle;
    }
  }

  updateStats() {
    this.totalTasks = this.tasks.length;
    this.completedTasks = this.tasks.filter(t => t.completed).length;
  }

  get progress(): number {
    if (this.totalTasks === 0) return 0;
    return Math.round((this.completedTasks / this.totalTasks) * 100);
  }

  get filteredTasks() {
    return this.tasks.filter(task =>
      task.title.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }

}
