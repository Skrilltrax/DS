#include "AVLNode.hpp"
#include <algorithm>

void updateHeighAndBal(AVLNode *node)
{
    int leftHeight = -1;
    int rightHeight = -1;

    if (node->left != nullptr)
        leftHeight = node->left->height;

    if (node->right != nullptr)
        rightHeight = node->right->height;

    node->height = std::max(leftHeight, rightHeight);
    node->bal = leftHeight - rightHeight;
}

AVLNode *llRotate(AVLNode *node)
{
    AVLNode *leftNode = node->left;
    node->left = leftNode->right;
    leftNode->right = node;

    updateHeighAndBal(node);
    updateHeighAndBal(leftNode);

    return leftNode;
}

AVLNode *rrRotate(AVLNode *node)
{
    AVLNode *rightNode = node->right;
    node->right = rightNode->left;
    rightNode->left = node;

    updateHeighAndBal(node);
    updateHeighAndBal(rightNode);

    return rightNode;
}

AVLNode *rotate(AVLNode *node)
{
    updateHeighAndBal(node);
    if (node->bal == 2)
    {
        if (node->left->bal == 1)
        {
            return llRotate(node);
        }
        else
        {
            node->left = rrRotate(node->left);
            return llRotate(node);
        }
    }
    else
    {
        if (node->right->bal == -1)
        {
            return rrRotate(node->right);
        }
        else
        {
            node->right = llRotate(node->right);
            return rrRotate(node);
        }
    }
}