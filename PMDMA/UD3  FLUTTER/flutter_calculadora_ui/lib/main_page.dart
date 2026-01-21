import 'package:flutter/material.dart';
import 'package:flutter_calculadora_ui/shared/calculator_button.dart';

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.black,
      padding: EdgeInsets.all(16),
      child: Column(
        children: [
          Expanded(
            flex: 2,
            child: Padding(
              padding: const EdgeInsets.fromLTRB(0,20,0,0),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Container(
                    padding: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      color: const Color.fromARGB(255, 34, 34, 34),
                      borderRadius: BorderRadius.circular(100),
                      border: Border.all(
                        color: const Color.fromARGB(255, 54, 54, 54),
                      ),
                    ),
                    child: Icon(Icons.list, color: Colors.white, size: 30),
                  ),
                  Container(
                    padding: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      color: const Color.fromARGB(255, 34, 34, 34),
                      borderRadius: BorderRadius.circular(100),
                      border: Border.all(
                        color: const Color.fromARGB(255, 54, 54, 54),
                      ),
                    ),
                    child: Icon(Icons.calculate, color: Colors.white, size: 30),
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            flex: 2,
            child: SizedBox(
              height: double.infinity,
              width: double.infinity,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  Text(
                    "38,670÷50,000",
                    style: TextStyle(color: Colors.grey, fontSize: 30),
                  ),
                  Text(
                    "0.7734",
                    style: TextStyle(color: Colors.white, fontSize: 60),
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            flex: 6,
            child: SizedBox(
              child: Column(
                spacing: 10,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CalculatorButton(
                        backgroundColor: Colors.grey,
                        textButton: "Del",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.grey,
                        textButton: "AC",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.grey,
                        textButton: "%",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.orange,
                        textButton: "÷",
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "7",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "8",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "9",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.orange,
                        textButton: "×",
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "4",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "5",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "6",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.orange,
                        textButton: "-",
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "1",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "2",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "3",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.orange,
                        textButton: "+",
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "+/-",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: "0",
                      ),
                      CalculatorButton(
                        backgroundColor: const Color.fromARGB(255, 54, 54, 54),
                        textButton: ".",
                      ),
                      CalculatorButton(
                        backgroundColor: Colors.orange,
                        textButton: "=",
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
