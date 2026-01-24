import 'package:flutter/material.dart';

class MeetingItem extends StatefulWidget {
  const MeetingItem({
    super.key,
    required this.day,
    required this.month,
    required this.title,
    required this.startTime,
    required this.endTime,
    required this.iconUrl,
    required this.done,
  });

  final String title, month, day, startTime, endTime, iconUrl;
  final bool done;

  @override
  State<MeetingItem> createState() => _MeetingItemState();
}

class _MeetingItemState extends State<MeetingItem> {
  late bool isDone;

  @override
  void initState() {
    super.initState();
    isDone = widget.done;
  }

  void _showOptions(BuildContext context) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text("Opciones de reunión"),
        content: const Text("¿Qué deseas hacer con este evento?"),
        actions: [
          TextButton(
            onPressed: () {
              setState(() {
                isDone = !isDone;
              });
              Navigator.pop(context);
            },
            child: Text(
              isDone ? "Marcar como no realizado" : "Marcar como realizado",
              style: const TextStyle(color: Colors.green),
            ),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {

    final Color titleColor = isDone ? Colors.grey : Colors.black;
    final Color timeBoxColor = isDone ? Colors.grey.shade300 : const Color.fromARGB(255, 224, 245, 250);
    final Color timeTextColor = isDone ? Colors.grey : const Color.fromARGB(255, 21, 74, 112);

    return GestureDetector(
      onTap: () => _showOptions(context),
      child: Container(
        height: 100,
        padding: const EdgeInsets.all(15.0),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(25.0),
          color: Colors.white,
        ),
        child: Row(
          spacing: 20,
          children: [
            Expanded(
              flex: 2,
              child: Container(
                height: 75,
                decoration: BoxDecoration(
                  color: isDone ? Colors.grey : Colors.white,
                  boxShadow: isDone
                      ? []
                      : [
                          BoxShadow(
                            color: const Color.fromARGB(85, 158, 158, 158),
                            spreadRadius: 2,
                            blurRadius: 5,
                            offset: const Offset(0, 3),
                          ),
                        ],
                  borderRadius: BorderRadius.circular(15.0),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      widget.month,
                      style: TextStyle(color: isDone ? Colors.grey[600] : Colors.black, fontSize: 15),
                    ),
                    Text(
                      widget.day,
                      style: TextStyle(color: isDone ? Colors.grey[800] : Colors.black, fontSize: 28),
                    ),
                  ],
                ),
              ),
            ),
            Expanded(
              flex: 7,
              child: Column(
                spacing: 5,
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    widget.title,
                    style: TextStyle(
                      color: titleColor,
                      fontSize: 16,
                      fontWeight: FontWeight.w600,
                      decoration: isDone
                          ? TextDecoration.lineThrough
                          : TextDecoration.none,
                    ),
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Container(
                        width: 140,
                        padding: const EdgeInsets.all(8.0),
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(15.0),
                          color: timeBoxColor,
                        ),
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          mainAxisAlignment: MainAxisAlignment.center,
                          spacing: 5,
                          children: [
                            Icon(
                              Icons.watch_later_outlined,
                              color: timeTextColor,
                              size: 20,
                            ),
                            Text(
                              "${widget.startTime} - ${widget.endTime}",
                              style: TextStyle(
                                fontWeight: FontWeight.w600,
                                color: timeTextColor,
                                fontSize: 15,
                              ),
                            ),
                          ],
                        ),
                      ),
                      Image.network(
                        widget.iconUrl,
                        height: 40,
                        width: 40,
                        color: isDone ? Colors.grey : null,
                        colorBlendMode: isDone ? BlendMode.modulate : null,
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
