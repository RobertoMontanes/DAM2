import 'package:flutter/material.dart';
import 'package:flutter_ejemplo_01/pages/home_page_view.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        primaryColor: Colors.blueAccent,
        useMaterial3: true,
      ),
      home: const HomePageView(),
    );
  }
}
