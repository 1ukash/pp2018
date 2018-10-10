package ru.spbstu.tema.pp.lecture05;

public class AppWithUI {
	
	class MouseImpl implements MyMouseListener {
		@Override
		public void mouseClicked() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseReleased() {
			// TODO Auto-generated method stub
			
		}
	}
	
	static class Button {
		private MyMouseListener l;

		public Button(MyMouseListener l) {
			super();
			this.l = l;
		}
		
	}

	void defineMouseBehavior() {
		Button b = new Button(new MouseImpl());
		
		Button exit = new Button(new MyMouseListener() {
			
			@Override
			public void mouseReleased() {
				// TODO Auto-generated method stub
				System.out.println("released!");
			}
			
			@Override
			public void mousePressed() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
