import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.amber,
      child: Center(child: ActorCage(),)
    );
  }
}

class ActorCage extends StatelessWidget {
  const ActorCage({super.key,});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
        height: 400,
        width: 200,
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(20),
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Expanded(
                flex: 7,
                child: Container(
                  clipBehavior: Clip.antiAlias,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(100)
                  ),
                  child: Image.network(
                    'https://media.themoviedb.org/t/p/w300_and_h450_face/qYiaSl0Eb7G3VaxOg8PxExCFwon.jpg',
                    fit: BoxFit.cover,
                    ),
                  )
                ),
              Expanded(
                flex: 3,
                child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                    Text("Sidney", style: TextStyle(fontSize: 20)),
                    Text("Sweeney", style: TextStyle(fontSize: 20))
                  ],
                )
                ),
            ],
          )
        ),
      );
  }
}