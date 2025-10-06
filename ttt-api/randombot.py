from rdfstore import RDFStore
import random

# 
# This opponent randomly picks an available square from the array. 
#
class RANDOMBOT():

    def __init__(self, uri, helper):
        self.uri = uri
        self.helper = helper
    

    def make_move(self):
        free_squares = self.helper.get_free_squares()
        if (len(free_squares) > 0):
            index = random.randint(0, len(free_squares)-1) 
            self.helper.add_move(free_squares[index], self.uri)
            return True
        else:
            return False
        

    def get_desc():
        return "This opponent randomly picks the next available square."