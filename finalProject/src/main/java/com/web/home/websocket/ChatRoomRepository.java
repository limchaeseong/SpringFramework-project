package com.web.home.websocket;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
	private Map<String, Chatroom> chatRoomMap;
	

	public ChatRoomRepository() {
		chatRoomMap = new LinkedHashMap<String, Chatroom>();
	}
	
	public List<Chatroom> findAllRoom(){
		if(chatRoomMap.isEmpty()==false) {
			System.out.println("채팅방 수 : "+chatRoomMap.size());
			if(chatRoomMap.size()!=0) {
			List<Chatroom> chatRooms = new ArrayList<Chatroom>(chatRoomMap.values());
			return chatRooms;
			}
		}
		return null;
	}
	
	public Chatroom findRoomById(int id) {
		return chatRoomMap.get(Integer.toString(id));
	}
	
	public boolean findRoomnBoolean(int id) {
		return chatRoomMap.containsKey(Integer.toString(id));
	}
	
	public Chatroom createChatRoom(int id) {
		Chatroom chatroom = Chatroom.create(id);
		chatRoomMap.put(Integer.toString(chatroom.getRoomId()), chatroom);
		return chatroom;
	}
	
	public int MemberNum(int id) {
		return this.findRoomById(id).getSessionList().size();
	}
	
	public void Delete_Chatroom(int id){
		chatRoomMap.remove(Integer.toString(id));
		System.out.println("채팅방 갯수 : "+chatRoomMap.size());
	}
}
