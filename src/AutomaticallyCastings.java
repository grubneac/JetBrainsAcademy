public class AutomaticallyCastings {
    public static void main(String[] args) {
        char cVar ='C';
        int iVar = cVar;
        System.out.println(iVar);

        long lVar = 13123123L;
        float fVar = lVar;
        System.out.println(fVar);

        byte bVar = 1;
        short sVar = bVar;
//        cVar = sVar;

    }
}
