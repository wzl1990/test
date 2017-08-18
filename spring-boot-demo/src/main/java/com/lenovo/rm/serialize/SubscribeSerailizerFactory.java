package com.lenovo.rm.serialize;

/**
 * @author zhenglong.wei
 *
 */
public class SubscribeSerailizerFactory {
	
	public static SubscribeSerializer jacksonSerializer=null;
	
	public static ProtostuffSerializer protostuffSerializer=null;
	
	private SubscribeSerailizerFactory() {
    }
	
	public static SubscribeSerializer getJacksonInstance(){
		if(jacksonSerializer==null){
			synchronized (SubscribeSerailizerFactory.class) {
				if(jacksonSerializer==null){
					jacksonSerializer=new JacksonSerailizerImpl();
				}
			}
		}
		return jacksonSerializer;
	}
	
	public static ProtostuffSerializer getProtostuffInstance(){
		if(protostuffSerializer==null){
			synchronized (SubscribeSerailizerFactory.class) {
				if(protostuffSerializer==null){
					protostuffSerializer=new ProtostuffSerailizerImpl();
				}
			}
		}
		return protostuffSerializer;
	}
	
/*	public static void main(String[] args) throws Exception {
		JacksonSerializer jacksonSerializer=new JacksonSerailizerImpl();
		ProtostuffSerializer protostuffSerializer=new ProtostuffSerailizerImpl();
		Subscribe s=new Subscribe();
		s.setBusinessKey("adsfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacd");s.setClientName("cdadddddddddddddddddddcdasdafdsfadf");
		s.setConsumeFromWhere("sadfasdkfjsadkfasdkfasdjfasdfadsfasdf");s.setCreateTime(new Date());s.setId(112214324);
		s.setGroupName("ASDFDFADSFADSFASDFDSAFSDFSDFDSGFDSGDSFGDSFGDSFHGFDHFDHGFJAFEFQWEFQEFQWEFQEWFQEW");
		long start1=System.currentTimeMillis();
		String j=jacksonSerializer.serail(s);
		System.out.println(System.currentTimeMillis()-start1);
		
		long start12=System.currentTimeMillis();
		Subscribe sj=jacksonSerializer.deserail(j);
		System.out.println(System.currentTimeMillis()-start12);
		
		long start2=System.currentTimeMillis();
		byte[] p=protostuffSerializer.serail(s);
		System.out.println(System.currentTimeMillis()-start2);
		
		long start22=System.currentTimeMillis();
		Subscribe pj=protostuffSerializer.deserail(p);
		System.out.println(System.currentTimeMillis()-start22);
		
		System.out.println(j.getBytes().length);
		System.out.println(p.length);
	}
    */
}