package observermodel;
/**
 * ����һ���۲��߽ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 * @author Administrator
 *
 */
public interface Observer {
	/**
	 * ���µĽӿ�
	 * @param subject����Ŀ����󣬷����ȡ��Ӧ��Ŀ������״̬
	 */
	public void update(Subject subject);
}
