package mytreeproject;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Вставка элементов
        int[] numbers = {50, 30, 20, 40, 70, 60, 80};
        for (int num : numbers) {
            tree.insert(num);
        }
        
        // Демонстрация работы
        System.out.print("In-order обход: ");
        tree.inOrder();
        
        System.out.println("Поиск 40: " + tree.search(40));
        System.out.println("Количество узлов: " + tree.countNodes());
        System.out.println("Высота дерева: " + tree.height());
        
        System.out.println("Удаление 20:");
        tree.delete(20);
        System.out.print("In-order после удаления: ");
        tree.inOrder();
    }
}
