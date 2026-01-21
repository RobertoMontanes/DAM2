import 'package:flutter/material.dart';

class RectangleButon extends StatelessWidget {
  const RectangleButon({
    super.key,
    required this.content,
    this.backgroundColor = Colors.white,
  });

  final String content;
  final Color backgroundColor;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 80,
      width: 130,
      child: ElevatedButton(
        style: ButtonStyle(
          elevation: WidgetStatePropertyAll(0),
          backgroundColor: WidgetStatePropertyAll(backgroundColor),
          shape: WidgetStatePropertyAll(
            RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
          ),
        ),
        onPressed: () => {},
        child: Text(
          content,
          style: TextStyle(
            fontSize: 40,
            fontWeight: FontWeight.bold,
            color: Colors.black,
          ),
        ),
      ),
    );
  }
}
