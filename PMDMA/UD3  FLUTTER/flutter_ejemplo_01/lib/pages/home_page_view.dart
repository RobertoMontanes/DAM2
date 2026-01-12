import 'package:flutter/material.dart';

class HomePageView extends StatelessWidget {
  const HomePageView({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        height: double.infinity,
        color: Color(0xFFE62F16),
        child: Padding(
          padding: const EdgeInsets.all(100), 
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                children: [
                  Image.asset('assets/images/path_logo.png'),
                  Text("Beautiful, Private Sharing", style: TextStyle(color: Color(0xFFfe9f85))),
                ],
              ), // Titulo
              Column(children: [
                FilledButton(
                  onPressed: () => {}, 
                  style: ButtonStyle(
                    backgroundColor: WidgetStateProperty.all(Colors.white),
                    padding: WidgetStateProperty.all(EdgeInsets.symmetric(vertical: 15, horizontal: 70)), 
                    shape: WidgetStateProperty.all(RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8),
                    )),
                  ),
                  child: const Text("Sign Up", style: TextStyle(color: Color(0xFFE62F16), fontSize: 20),)
                ),
                Padding(padding: EdgeInsetsGeometry.all(10)),
                Text("Already have a Path account?", style: TextStyle(color: Color(0xFFfe9f85))),
                FilledButton(
                  onPressed: () => {}, 
                  style: ButtonStyle(
                    backgroundColor: WidgetStateProperty.all(Color(0xFFE62F16)),
                    padding: WidgetStateProperty.all(EdgeInsets.symmetric(vertical: 15, horizontal: 70)),
                    side: WidgetStateProperty.all(BorderSide(color: Color(0xFFfe9f85), width: 1)),
                    shape: WidgetStateProperty.all(RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8),
                    )),
                  ),
                  child: const Text("Log In", style: TextStyle(color: Color(0xFFfe9f85), fontSize: 20),)
                ),
                Padding(padding: EdgeInsetsGeometry.all(10)),
                RichText(
                  text: TextSpan(
                  style: TextStyle(color: Color(0xFFfe9f85)),
                  children: [
                    TextSpan(text: "By using Path, you agree to Path's "),
                    TextSpan(
                      text: "Terms of Use",
                      style: TextStyle(color: Colors.white, decoration: TextDecoration.underline),
                    ),
                    TextSpan(text: " and "),
                    TextSpan(
                      text: "Privacy Policy",
                      style: TextStyle(color: Colors.white, decoration: TextDecoration.underline),
                    )
                  ],
                  ),
                ),
              ],), // Botones
          ]),
        ),
      ),
    );
  }
}
