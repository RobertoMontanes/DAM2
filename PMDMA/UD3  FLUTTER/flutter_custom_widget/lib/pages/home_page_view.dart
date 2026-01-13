import 'package:flutter/material.dart';
import 'package:flutter_custom_widget/shared/rectangle_button.dart';

class HomePageView extends StatelessWidget {
  const HomePageView({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Column(
          children: [
            SizedBox(
              height: 100,
            ),
            Center(child: Rectanglebutton(
              text: "Log In",
              backgroundColor: Colors.redAccent,
              color: Colors.black,
              height: 20.00,
              width: 100.00,
            ),)
          ],
        ),
      ),
    );
  }
}