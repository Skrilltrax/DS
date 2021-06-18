#include "../Node.hpp"
#include <iostream>
#include <stack>
using namespace std;

class NodeData
{
public:
    Node *node;
    bool self = false;
    bool left = false;
    bool right = false;

    NodeData(Node *node)
    {
        this->node = node;
    }
};

void preorder(Node *node)
{
    stack<NodeData *> stack;
    NodeData *nodeData = new NodeData(node);
    stack.push(nodeData);

    while (stack.size() != 0)
    {
        NodeData *top = stack.top();

        if (!top->self)
        {
            top->self = true;
            cout << top->node->data << endl;
        }
        else if (!top->left)
        {
            top->left = true;

            if (top->node->left != nullptr)
                stack.push(new NodeData(top->node->left));
        }
        else if (!top->right)
        {
            top->right = true;

            if (top->node->right != nullptr)
                stack.push(new NodeData(top->node->right));
        }
        else
        {
            stack.pop();
        }
    }
}

void postorder(Node *node)
{
    stack<NodeData *> stack;
    NodeData *nodeData = new NodeData(node);
    stack.push(nodeData);

    while (stack.size() != 0)
    {
        NodeData *top = stack.top();
        if (!top->left)
        {
            top->left = true;
            if (top->node->left != nullptr)
                stack.push(new NodeData(top->node->left));
        }
        else if (!top->right)
        {
            top->right = true;
            if (top->node->right != nullptr)
                stack.push(new NodeData(top->node->right));
        }
        else if (!top->self)
        {
            top->self = true;
            cout << top->node->data << endl;
        }
        else
        {
            stack.pop();
        }
    }
}

void inorder(Node *node)
{
    stack<NodeData *> stack;
    NodeData *nodeData = new NodeData(node);
    stack.push(nodeData);

    while (stack.size() != 0)
    {
        NodeData *top = stack.top();

        if (!top->left)
        {
            top->left = true;
            if (top->node->left != nullptr)
                stack.push(new NodeData(top->node->left));
        }
        else if (!top->self)
        {
            top->self = true;
            cout << top->node->data << endl;
        }
        else if (!top->right)
        {
            top->right = true;
            if (top->node->right != nullptr)
                stack.push(new NodeData(top->node->right));
        }
        else
        {
            stack.pop();
        }
    }
}

int main()
{

    Node *node5 = new Node(5);
    Node *node4 = new Node(4);
    Node *node3 = new Node(3);
    Node *node2 = new Node(2, node4, node5);
    Node *node1 = new Node(1, node2, node3);

    preorder(node1);
    cout << endl;
    postorder(node1);
    cout << endl;
    inorder(node1);
    return 0;
}