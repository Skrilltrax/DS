from typing import List


# noinspection PyMethodMayBeStatic
class Solution:
    def generate(self, num_rows: int) -> List[List[int]]:
        pascal_list: List[List[int]] = []
        for i in range(num_rows):
            if i == 0:
                row = self.create_row(i, [])
            else:
                row = self.create_row(i, pascal_list[i - 1])

            pascal_list.append(row)

        return pascal_list

    # noinspection PyListCreation
    def create_row(self, row_number: int, previous_row: List[int]):
        if row_number == 1:
            return [1]

        new_row: List[int] = []

        # Append the beginning 1
        new_row.append(1)

        for i in range(len(previous_row) - 1):
            first_num: int = previous_row[i]
            second_num: int = previous_row[i + 1]
            new_row.append(first_num + second_num)

        # Append the ending 1
        new_row.append(1)
