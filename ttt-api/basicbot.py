from rdfstore import RDFStore

# 
# The square array is ordered from left to right, top row to bottom row.
# This opponent always picks the next available square from the array. 
#
class BASICBOT():

    def __init__(self, uri, helper):
        self.uri = uri
        self.helper = helper
    

    def make_move(self):
        free_squares = self.helper.get_free_squares()
        if (len(free_squares) > 0):
            self.helper.add_move(free_squares[0], self.uri)
            return True
        else:
            return False
        
    
    def get_desc():
        return "This opponent always picks the next available square in order from left->right, top->bottom of the board."