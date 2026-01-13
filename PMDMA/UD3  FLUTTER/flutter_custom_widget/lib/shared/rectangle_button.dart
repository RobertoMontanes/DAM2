import 'package:flutter/material.dart';

class Rectanglebutton extends StatelessWidget {
  const Rectanglebutton(
    {
      super.key, 
      required this.text,
      required this.color,
      required this.backgroundColor,
      required this.height,
      required this.width,
      }
    );

  final String text;
  final Color color;
  final Color backgroundColor;
  final double height;
  final double width;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: height,
      width: width,
      child: Container(
        color: backgroundColor,
        height: double.infinity,
        width: double.infinity,
        child: 
          Center(
            child: Text(
              text, style: TextStyle(color: color)
            ),
          ),
      ),
    );
  }
}