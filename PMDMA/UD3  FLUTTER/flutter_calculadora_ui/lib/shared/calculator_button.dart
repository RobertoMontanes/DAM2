import 'package:flutter/material.dart';

class CalculatorButton extends StatelessWidget {
  const CalculatorButton(
    {
      super.key,
      required this.backgroundColor,
      required this.textButton,
    }
  );

  final Color backgroundColor;
  final String textButton;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 85,
      width: 85,
      child: ElevatedButton(
        onPressed: () => {},
        style: ElevatedButton.styleFrom(backgroundColor: backgroundColor, padding: EdgeInsets.all(0)),
        child: Center(
          child: Text(
            textButton,
            style: TextStyle(fontSize: 40, color: Colors.white, fontWeight: FontWeight.normal),
          ),
        ),
      ),
    );
  }
}
