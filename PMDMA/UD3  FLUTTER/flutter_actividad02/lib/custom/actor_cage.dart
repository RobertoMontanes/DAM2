import 'package:flutter/material.dart';


/// Chat de CHATGPT usado pa esta cosa: 
/// https://chatgpt.com/share/6966dad8-37b0-8001-8f6e-16e820aa1e1d
/// 
/// Solo hay algunas preguntas de componentes y tal, pero por si.


class ActorCage extends StatelessWidget {
  const ActorCage(
    {
      super.key,
      required this.actorName,
      required this.actorLastName,
      required this.imgUrl,
      }
  );

  final String actorName;
  final String actorLastName;
  final String imgUrl;

  @override
  Widget build(BuildContext context) {
    return Center(
      child: SizedBox(
        height: 600,
        width: 200,
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
                    imgUrl,
                    fit: BoxFit.cover,
                    ),
                  )
                ),
              Expanded(
                flex: 3,
                child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                    Text(actorName, style: TextStyle(fontSize: 35, color: Colors.black, fontFamily: 'Poppins')),
                    Text(actorLastName, style: TextStyle(fontSize: 15, color: Colors.grey[600], fontFamily: 'Poppins')),
                  ],
                )
                ),
            ],
          )
        ),
    );
  }
}