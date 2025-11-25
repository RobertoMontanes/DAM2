import { Component, Input, input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-custom-progress-bar-component',
  imports: [],
  templateUrl: './custom-progress-bar-component.html',
  styleUrl: './custom-progress-bar-component.css',
})
export class CustomProgressBarComponent implements OnChanges {

  value = input<Number>()
  color = input<String>()
  isStriped = input<Boolean>(false)
  showProgress = input<Boolean>(true)

  ngOnChanges(changes: SimpleChanges): void {
    document.getElementById("progressBar")!.setAttribute("style", "width: " + this.value + "%; background-color: " + this.color + ";");

    if (this.isStriped()) {
      document.getElementById("progressBar")!.classList.add("progress-bar-striped");
    } else {
      document.getElementById("progressBar")!.classList.remove("progress-bar-striped");
    }
  }

  
}
