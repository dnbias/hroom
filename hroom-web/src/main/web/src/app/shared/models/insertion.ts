import{Tag} from "./tags";

export interface insertion {
  insertion_type: string;
  id: number;
  landlordId: number;
  name: string;
  tags: Tag[];
  description: string[];
  price: number;
  city: string;
  address: string;
  area: number;
  photoUrl: string;
  rating: number;
  receivedFeedbacksIds: number[];
  availabilityId: number;
}
