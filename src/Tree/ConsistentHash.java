package Tree;

import java.util.*;

/**
 * Tree
 * description: 一致性Hash （ip-hash为例）
 * author:mingzhe Xiang
 * date:2018/4/14
 */
public class ConsistentHash {

    //虚拟节点数
    private final static int VIRTUAL_NODE_SIZE = 5;
    //初始真实节点
    private static TreeMap<Long, String> hashNodeMap = new TreeMap<>();

    //Hash环 (treeMap 默认提供排序)
    private static void init() {
        // 初始化真实节点
        List<String> realNodeList = new ArrayList<>();
        realNodeList.add("192.168.1.1");
        realNodeList.add("192.168.2.2");
        realNodeList.add("192.168.3.3");
        realNodeList.add("192.168.4.4");
        realNodeList.add("192.168.5.5");
        // 初始化hash环
        for (String realNode : realNodeList) {
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                hashNodeMap.put(hash(realNode + "-VN-" + i), realNode);
            }
        }
    }

    private static long hash(String node) {
        // 简化demo 直接使用了String的hashCode 但String的hashCode会造成节点分布极其不均甚至溢出的问题 实际场景会使用其他常见的hash算法
        return node.hashCode();
        // MURMUR_HASH
        // CRC_HASH,FNV1_64_HASH,
        // FNV1A_64_HASH,
        // FNV1_32_HASH,
        // FNV1A_32_HASH,
        // KETAMA_HASH
    }

    /**
     * 新增节点
     *
     * @param nodeIp
     */
    private static void addNode(String nodeIp) {
        for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
            hashNodeMap.put(hash(nodeIp + "-VN-" + i), nodeIp);
        }
    }

    /**
     * 删除(下线)节点
     *
     * @param nodeIp
     */
    private static void removeNode(String nodeIp) {
        for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
            hashNodeMap.remove(hash(nodeIp + "-VN-" + i), nodeIp);
        }
    }

    private static String getNodeIp(String clientIp) {
        // tailMap() 返回treeMap中大于等于fromKey的数据
        //        SortedMap<Long, String> nodeTailMap = hashNodeMap.tailMap(hash(clientIp));
        //        if (nodeTailMap.isEmpty()) {
        //            //nodeTailMap为空表明目标key超过最大key 由于一致性hash为环形hash 此时目标key就应变为头key
        //            return hashNodeMap.firstEntry().getValue();
        //        }
        //        return hashNodeMap.get(nodeTailMap.firstKey());


        Map.Entry<Long, String> higherEntry = hashNodeMap.higherEntry(hash(clientIp));
        if (null == higherEntry) {
            return hashNodeMap.firstEntry().getValue();
        }

        return higherEntry.getValue();
    }

    public static void main(String[] args) {
        init();
        String clientIp;
        for (int i = 0; i < 10; i++) {
            clientIp = "221.43.21." + (int) (Math.random() * 255);
            // 由于使用String的hashCode作为hash函数 打印结果可看出分布及其不均
            System.out.println(String.format("clientIp:%s ---> serverIp:%s", clientIp, getNodeIp(clientIp)));
        }
    }
}
