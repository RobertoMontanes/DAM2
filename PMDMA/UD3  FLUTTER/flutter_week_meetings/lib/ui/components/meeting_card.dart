import 'package:flutter/material.dart';
import 'package:flutter_week_meetings/ui/components/meeting_item.dart';

class MeetingCard extends StatelessWidget {
  const MeetingCard({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(50.0),
        border: Border.all(color: Colors.grey[300]!, width: 2.0),
        color: Colors.white,
      ),
      child: Container(
        margin: const EdgeInsets.all(5.0),
        height: 700,
        decoration: BoxDecoration(
          color: Colors.grey[200],
          //color: Colors.red,
          borderRadius: BorderRadius.circular(50.0),
        ),
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    "Your meetings",
                    style: TextStyle(
                      color: const Color.fromARGB(255, 73, 73, 73),
                      fontSize: 20,
                    ),
                  ),
                  Icon(
                    Icons.more_horiz,
                    color: const Color.fromARGB(255, 73, 73, 73),
                  ),
                ],
              ),
              Text(
                "Weekly schedule",
                style: TextStyle(color: Colors.black, fontSize: 28),
              ),
              SizedBox(height: 20),
              Expanded(
                child: ListView(
                  children: [
                    MeetingItem(
                      day: '15',
                      month: 'Sep',
                      title: 'Meeting with marketing team',
                      startTime: '13:00',
                      endTime: '13:45',
                      iconUrl:
                          'https://cdn-icons-png.flaticon.com/512/5968/5968552.png',
                      done: false,
                    ),
                    SizedBox(height: 15),
                    MeetingItem(
                      day: '16',
                      month: 'Sep',
                      title: 'Meeting with marketing team',
                      startTime: '12:00',
                      endTime: '12:45',
                      iconUrl:
                          'https://cdn-icons-png.flaticon.com/512/4401/4401470.png',
                      done: false,
                    ),
                    SizedBox(height: 15),
                    MeetingItem(
                      day: '17',
                      month: 'Sep',
                      title: 'Meeting with marketing team',
                      startTime: '10:00',
                      endTime: '12:00',
                      iconUrl:
                          'https://cdn-icons-png.flaticon.com/512/15047/15047490.png',
                      done: true,
                    ),
                    SizedBox(height: 15),
                    MeetingItem(
                      day: '17',
                      month: 'Sep',
                      title: 'Meeting with new client',
                      startTime: '15:00',
                      endTime: '16:45',
                      iconUrl:
                          'https://cdn-icons-png.flaticon.com/512/5968/5968552.png',
                      done: true,
                    ),
                    SizedBox(height: 15),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
