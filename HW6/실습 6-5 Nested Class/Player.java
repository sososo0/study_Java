public abstract class Player{
    public String name;
    public int jerseyNumber;
    protected int speed;
    public String type;

    public static class Builder{
        private String type;
        private String name;
        private int jerseyNumber;
        private int speed;

        public Builder setPlayerType(String type){
            this.type = type;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setJerseyNumber(int num){
            this.jerseyNumber = num;
            return this;
        }
        public Builder setSpeed(int speed){
            speed = build().getSpeed();
            this.speed = speed;
            return this;
        }

        public Player build(){
            Player player = new Player() {
                Player Midfielder = new MidFielder();
                Player Forward = new Forward();
                Player Defender = new Defender();

                @Override
                protected int getSpeed(){
                    if(type.length() == 10){
                        return Midfielder.getSpeed();
                    }else if(type.length() == 7){
                        return Forward.getSpeed();
                    }else {return Defender.getSpeed();}
                }
            };
            player.type = type;
            player.name = name;
            player.speed = speed;
            player.jerseyNumber = jerseyNumber;
            return player;
        }
    }
    protected abstract int getSpeed();

    @Override
    public String toString(){
        return "Player Name='"+name+", JerseyNumber="+jerseyNumber+", SPEED="+speed+", "+type.substring(0,1).toUpperCase()+type.substring(1);
    }
}
